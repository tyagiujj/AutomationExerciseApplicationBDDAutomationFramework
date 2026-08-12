# Push helper script for this repository
# Usage: Open PowerShell in the repository root and run:
#   powershell -ExecutionPolicy Bypass -File .\push_to_github.ps1

function Write-ErrorAndExit($msg) {
    Write-Host $msg -ForegroundColor Red
    exit 1
}

# Check git availability
if (-not (Get-Command git -ErrorAction SilentlyContinue)) {
    Write-ErrorAndExit "Git is not installed or not on PATH. Install Git for Windows and try again: https://git-scm.com/download/win"
}

$repoPath = Get-Location
Write-Host "Repository path: $repoPath"

# Is this a git repo?
$gitDir = Join-Path $repoPath ".git"
$needInit = -not (Test-Path $gitDir)
if ($needInit) {
    Write-Host "No .git directory found. Initializing repository..."
    git init || Write-ErrorAndExit "git init failed"
} else {
    Write-Host ".git directory exists. Using existing repository."
}

# Configure user.name and user.email if not set
$userName = git config user.name
$userEmail = git config user.email
if (-not $userName) {
    $userName = Read-Host "Enter git user.name (e.g. Your Name)"
    if ($userName) { git config user.name "$userName" }
}
if (-not $userEmail) {
    $userEmail = Read-Host "Enter git user.email (e.g. you@example.com)"
    if ($userEmail) { git config user.email "$userEmail" }
}

Write-Host "git user.name: " (git config user.name)
Write-Host "git user.email: " (git config user.email)

# Stage changes
Write-Host "Staging all files..."
git add .

# Commit if there are staged changes
$diffIndex = git diff --cached --name-only
if ($diffIndex) {
    $msg = Read-Host "Enter commit message (default: Initial commit)"
    if (-not $msg) { $msg = "Initial commit - push project" }
    git commit -m "$msg" || Write-ErrorAndExit "git commit failed"
} else {
    Write-Host "No staged changes to commit."
}

# Set remote
$defaultRemote = "https://github.com/tyagiujj/FilpkartBDDAutomationFramework.git"
$remoteUrl = Read-Host "Enter remote repository URL (press Enter to use default: $defaultRemote)"
if (-not $remoteUrl) { $remoteUrl = $defaultRemote }

$originExists = (git remote | Select-String -Pattern '^origin$') -ne $null
if ($originExists) {
    $answer = Read-Host "Remote 'origin' already exists. Replace it? (y/N)"
    if ($answer -match '^[yY]') {
        git remote remove origin || Write-ErrorAndExit "Failed to remove existing origin"
    } else {
        Write-Host "Keeping existing origin. You can add a new remote manually if you prefer."
    }
}

if ((git remote) -notmatch 'origin') {
    git remote add origin $remoteUrl || Write-ErrorAndExit "git remote add failed"
    Write-Host "Remote 'origin' set to $remoteUrl"
}

# Ensure branch name is main by default
$branch = git branch --show-current
if (-not $branch) { $branch = 'main' }
$useBranch = Read-Host "Enter branch name to push (default: $branch)"
if ($useBranch) { $branch = $useBranch }

git branch -M $branch || Write-ErrorAndExit "Failed to set branch name to $branch"

# Push
Write-Host "Pushing to origin/$branch..."
$pushResult = git push -u origin $branch 2>&1
if ($LASTEXITCODE -ne 0) {
    Write-Host "git push failed with output:" -ForegroundColor Yellow
    Write-Host $pushResult
    Write-Host "Common causes: remote already has commits, authentication failure, or network issues." -ForegroundColor Cyan
    Write-Host "Recommended next steps:" -ForegroundColor Green
    Write-Host " 1) If authentication failed, create a GitHub Personal Access Token (PAT) and use it when prompted as the password for HTTPS pushes." -ForegroundColor Green
    Write-Host " 2) If remote contains unrelated history, you can fetch and merge: git fetch origin; git pull origin $branch --allow-unrelated-histories" -ForegroundColor Green
    Write-Host " 3) To avoid overwriting remote history, push to a new branch: git push -u origin HEAD:my-local-branch" -ForegroundColor Green
    Write-Host " 4) If you are sure you want to overwrite remote history (destructive), you can force push: git push -u origin $branch --force" -ForegroundColor Red
    exit 1
}

Write-Host "Push successful. Repository is on origin/$branch" -ForegroundColor Green
Write-Host "Open: $remoteUrl" -ForegroundColor Cyan

exit 0


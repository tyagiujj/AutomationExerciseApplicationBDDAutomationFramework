Filpkart BDD Automation Framework

This repository contains a Maven-based Java BDD automation framework (Cucumber + Selenium) for Flipkart.

Quick push helper

I added a helper script `push_to_github.ps1` to initialize the Git repository (if needed), create a commit, add the remote, and push to GitHub. This script is interactive and will prompt you for your git user.name and user.email if they are not set.

How to push from your machine

1) Open PowerShell and change to the project folder:

```powershell
Set-Location "C:\Users\DELL\Documents\untitled"
```

2) Run the helper script (allows running unsigned scripts for this execution only):

```powershell
powershell -ExecutionPolicy Bypass -File .\push_to_github.ps1
```

3) When prompted:
- Enter your name/email if asked
- Accept or change the remote URL (default: https://github.com/tyagiujj/FilpkartBDDAutomationFramework.git)
- Enter the branch name to push (default: main)

Notes

- If pushing via HTTPS, you'll need to enter your GitHub username and a Personal Access Token (PAT) when prompted for a password. Password authentication is deprecated.
- If you prefer SSH, change the remote URL to the SSH form: git@github.com:tyagiujj/FilpkartBDDAutomationFramework.git and ensure your SSH key is added to GitHub.
- If the push is rejected because the remote already contains commits, the script will show suggested next steps (pulling/merging, pushing to a new branch, or force pushing).

If you run the script and paste any error messages here, I will help you resolve them step by step.

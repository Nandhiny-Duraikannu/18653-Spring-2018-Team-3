# 18653-Spring-2018-Team-3

# Git Task Branch workflow
Let's develop using the git task branch workflow.

# Environment setup

## Setting up the database
Install MySQL.
Set the `root` password to `root`.

Create a database called `saddb`.
```
CREATE DATABASE saddb;
```

## Install sbt with Homebrew
If you do not have brew installed, install it by pasting this in the terminal:
```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

Once Homebrew is installed, install `sbt` using this:
```
brew install sbt@1
```

## Starting the project
Open the `frontend` folder in a terminal and run `sbt run -Dhttp.port=8080`. The front end will be served on port `9000`.

Open the `backend` folder in a terminal and run `sbt run -Dhttp.port=8081`. The front end will be served on port `9001`.

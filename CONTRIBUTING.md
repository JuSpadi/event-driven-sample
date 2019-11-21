# How to contribute to this project

## Step-by-step

Each new feature should reside in its own branch, which can be pushed to the central repository for backup/collaboration. But, instead of branching off of `master`, feature branches use `develop` as their parent branch. When a feature is complete, it gets merged back into `develop`. Features should never interact directly with `master`.

### 1. Create the feature branch

The first step when starting to work in a user story is to create a branch from `develop`.

### 2. Commit to the feature branch

Ideally, the commits should be as small and descriptive.

Please use the [**Semantic commit messages**](https://seesparkbox.com/foundry/semantic_commit_messages). Consider using [Commitzen](https://github.com/commitizen/cz-cli) in order to follow the guidelines.

> "Having a story in your git log will make a huge difference in how you and others perceive your project. By taking great care in commit messages, as you do in your code, you will help to increase overall quality." - [Caleb Thompson](https://robots.thoughtbot.com/5-useful-tips-for-a-better-commit-message)

### 3. Pull request to develop

One should not wait until the feature is complete before openning a _Pull request_ to the `develop` branch.

### 4. Pull request to master

At a given moment of the sprint, once the developers are confident with the changes that are already present in the `develop` branch, a Pull Request should be openned from `develop` to `master`. This is usually related to the deliver of the sprint, but not necessarily.

Once again, the CI will make sure to run all the automated tests in the develop branch. So it's must to have all the tests green.

This represents a release. So the merge can be properly tagged in git.
# Not So Rotten Tomatoes

## Description

The application is available for users to share their family recipes and review other recipes. User will have access to login and view other shares from users across the world. Each recipe card will have an image, recipe, and ability to add a review sharing your thoughts of it!

## Technology used

    Spring, PostgreSQL, ReactJS, Postman
    IntelliJ, VSCode, DBeaver

Initally will create two repos-- one for frontend, one for backend. Public, readme, add gitignore.
Front end: NSRT-UI
Back end: NSRT-API

## Executive Summary

- NSRT allows users to create an account and view recipes shared with one another in a community format.
- All members are allowed to access recipes(currently), create new recipes, and comment on recipes.
- Admins are allowed to moderate the site for any type of inappropriate comments .

### Member User Stories

- Sign up for an account with appropriate information (each uname and email are unique)
- Log in with the created account once signed up.
- Search through the existing recipe database that others have shared
- Create a new recipe with their own information and picture of the dish
- Delete or Update their pre-existing recipe submitted.
- Add reviews to other recipes they've tried for feedback to the creator
- Delete their account if they no longer want to use the service.

### Admin User Stories

- Log in feature will render seperately giving access to delete reviews not found appropriate.
- Admins will have the ability to create other admins to moderate the forum.
- Ability to delete reviews they do not find appropriate feedback or appropriate recipes.

### Stretch Goals

1. Add a dual view mode for light mode / dark mode.
2. Add SSO API for easier registration and sign in. (Google account)
3. Search feature will also hit key words of the description as well, not just the title.
4. Redo search from a complete search to an onStatusChange search
5. Implement a follow feature to other creators to see their recipes using a GET request.
6. Add a premium recipe feature which will lock certain recipes and add a payment Wall for the premium recipes.

### Setup

- [SETUP] Repository FE/BE
- [SETUP] Database RDS/pSQL
- [SETUP] Java Models/Servlet/Controllers
- [SETUP] Endpoints
- [BE FEATURE] Login Functionality
- [BE FEATURE] Logout Functionality
- [BE FEATURE] Search Functionality
- [BE FEATURE] Comment Functionality
- [BE FEATURE] Create Recipe Functionality
- [BE FEATURE] Update Recipe Functionality
- [BE FEATURE] Delete Recipe Functionality
- [BE FEATURE] Delete Account Functionality
- [FE DESIGN] Create Landing Page Nav (Site name, login search function)
- [FE DESIGN] Create Login/Register Page
- [FE DESIGN] Create Landing Page Cards for Recipes
- [FE DESIGN] Create User Profile Page

- [FE STRETCH] Redo Login with SSO API Functionality.
- [FE STRETCH] Add Light/Dark Mode switch
- [FE STRETCH] Create onStatusChange for Search functionality to auto populate
- [BE/FE STRETCH] Implement a follow feature to see other creator recipes quickly
- [FE STRETCH] Add premium recipe section to hide some until Paywall is uncovered (use API to "take payment")
- [FE STRETCH] Favorite recipes tab to nav bar, create page to host all "liked" recipes

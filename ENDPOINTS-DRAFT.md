ENDPOINTS DRAFT

/users
	-GET
	/:id --> for admin delete of unruly users, see below.

	-POST
	/register
	/login
	/logout

	-DELETE
	/delete/:id --> must authorize only OWN user id! maybe an admin can add a different user id?

	-PATCH
	/promote/:id --> for admin, user id to promote to admin

-------
/recipes

	-GET
	/ --> all recipes
	/search=? --> search param passed in
	/:id -->get a particular recipe, used for delete by admin, below

	-POST
	/newrecipe
	/recipe/delete/:id --> authorize only OWN user id, or if admin, any id

	-PATCH
	/recipe/:id/edit
--------

/reviews
	-GET
	/ --> get ALL reviews (unclear use case, maybe for debug only?)
	/:id --> get by REVIEW id (used for delete?)
	/recipe/:id --> get by RECIPE id (this should be the default view ie)

	-POST
	/recipe/:id --> the recipe id, ie

	-DELETE

	/:id --> for ADMIN. Disallow deleting reviews for OWN recipe, other admin ie must delete.
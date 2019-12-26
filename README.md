Test task for QA Automation position
Project description:
Two tests for ecopizza.com.ua website.

Some explanations:
* At the first step refresh page method is used as a workaround for closing email modal window which is appeared when user visits the website first time.
* Method currentPage.ifModalPresent() is used as a workaround for closing the modal window when a user visits the website before 10AM or 10PM. This modal is appeared on every page, so to make tests workable at this period this method was added.
* There are some mismatches is the task, e.g. there is no pizza filter on the main page, so the additional step was added
* Adding products to cart is performed from product pages. The reason is that on pizza page all selectors for choosing pizza size and adding to the cart the same for all products. I could reach the necessary element by pointing to the necessary element's number from the list or array, but it looked as hardcode for me, so I decided to make the test more universal and stable.
Project launch instructions:
You'll need to install PostgreSQL and Maven JDK 21.
Change ${LOGIN} and ${PASSWORD} properties in files application.properties and copmpose.yaml, for the ones you used for a database.
During the project creation a default server of PostgreSQL was used so, you just need to launch it and make Login and Password.
Open an IDE and use a Maven lifecycle option package to prepare the project.
Now launch the project itself either through IDE interface or from the "target" folder, which was created by previous step.
after that you'll see the project by going to "http://localhost:8080" adress in any web browser.

# Ktor on Google Cloud

## Features

- Deploy on App Engine
- Authentication
- Integration with Google Spreadsheets
- Store Data 
- Provide Some API services


---



## TODO
- Store data into Datastore



---


## Security

To enforce security to some resource you should use the ``authenticate`` coroutine like the example bellow.
Here the route ``home()`` is opened for the general public while ``homeSecure()`` is opened only for those users that has the pair username and password.  

__Application.kt__
```
    routing {
        // PUBLIC
        home()

        // SECURE
        authenticate("auth") {
          homeSecure()
        }
    }
```


To change username and password, update the code in Application.kt that describe the credentials.

```
    install(Authentication) {
        basic(name = "auth") {
           realm = "GCloudTemplateProject"
            validate {credentials ->
                if (credentials.password == "password" && credentials.name == "user") User(credentials.name) else null
            }
        }
    }
``` 

---


## Google Spreadsheets







---

## Google Cloud

1. Create the project <https://console.cloud.google.com/projectcreate>
2. Create an App Engine Application (hamburger menu > App Engine > Create Application button)
3. Install ```gcloud``` command line tool by downloading the SDK at the same page
4. Authenticate via command line ````cloud auth login````
5. Enable Google Sheets API <https://console.developers.google.com/apis/api/sheets.googleapis.com/overview>
6. Authorize Service Account <https://console.developers.google.com/iam-admin/serviceaccounts >
7. Click on __Create service account__ 
8. Choosse __Editor__ as the role so you can edit resources
9. Generate the Key and download it as JSON file. Rename it to ```credential.json``` and put into resources directory of the project


### Commands

Run it locally
> ./gradlew appengineRun


Deploy on Google Cloud / App Engine
> ./gradlew appengineDeploy 

List of the projects:
> gcloud projects list

Set the Project ID
> gcloud config set project PROJECT_ID

---

## Helpers

Google Cloud + KTor
<https://cloud.google.com/community/tutorials/kotlin-ktor-app-engine-java8?hl=pt-br>



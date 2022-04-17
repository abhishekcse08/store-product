When we add a dependency of spring security filter and start the project it won't allow us to access the resource using
filter.

[Applivation]-> |SPRING SECURITY|-> {CLIENT}
Spring security works as a middleware between application and client

*Filters-> this is a kind of servlet filter as we know all these framework  build on top of servlet therefore it's a kind of
            servlet filter,
            filter recives every request and logs. filter can be apply for all url.
Spring security default behaviour -
           1-:Mandatory authentication for all urls
           2-: add login form
           3-: handle login error
           4- create user(user) and set password default
 Authentication Manager do the authentication for your application, we work with builder class to configure
 We are not directly dealing with Authentication Manager
 Authentication Manager Builder->
configure

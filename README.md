# PetAdoptionWebsite


The following code is the demonstration code of Mahir Huseynov, Master student in BME. The project is the Master thesis work that present a Microservices Architecture based on Java/Spring. Each microservices deployed on Docker container.

<h2> Auth Server </h2>
<!--<h4>Features to add</h4> -->
There will be two types of users:
<ul>
  <li>Adopter</li>
  <li>Shelter</li>
</ul>
Here Shelter will be the admin. For example, user1 is the admin of Shelter1.
Adopter user can send a message to the shelter and look through the Pet list. And they can search choices of pets according to the infos.
Authentication will be built with OAuth2 and for Adopter it will be possible to sign up with Google. 

<h2> Adoptation Service </h2>
It will be seen by Shelter users and they can manage it
<ul>
  <li>List of Adoptions</li>
  <li>how many pets reamined in Shelter</li>
  <li>Infos of Adopter</li>
</ul>

<h2> Pet Service </h2>

Pet Service will serve as catalog of Pets.
<ul>
  <li>List of Pets</li>
  <li>Description of Pet</li>
  <li>Reference to the Shelter</li>
  <li> Searching pets</li>
</ul>

<h2> Shelter Service </h2>

It will store the list of Shelters.All the informations come from SignUp page will redirect and be stored in this Service. 

<h2> API Gateway(ZUUL) </h2>

This is the Api Gateway service. It will store the locations of services. And each services including UI can reach and send/receive req/res using this service.

<h2>Frontend</h2>

Built in Angular it will contain some pages for handling some Authentication requests.

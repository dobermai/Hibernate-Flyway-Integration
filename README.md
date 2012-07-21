Hibernate Flyway Integration
============================

What is it?
-----------

This POC was built to demonstrate, that it is possible to run a database migration tool like Flyway (http://code.google.com/p/flyway/) in a JavaEE6 Environment before Hibernate runs its schema export. It uses the Hibernate Integrator API to do Database migrations as Startup Jobs.

In which environments does it work?
-----------------------------------

The POC is only tested against Hibernate 4.1 and JBoss 7.1. It will most likely not work with other JPA Providers, since it depends on Hibernate APIs. It may work with other Application Servers, though.
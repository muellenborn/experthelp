# expertexchange

How to push
===========

Download and install the Cloud Foundry CLI: https://docs.cloudfoundry.org/cf-cli/install-go-cli.html#pkg

Run:

cf api api.eu-gb.cf.cloud.ibm.com --skip-ssl-validation

Login:

cf login

Enter the credentials

Now you can push from the main directory with

cf push

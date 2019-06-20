node {
  def app

  stage("clone repository"){
    // clone the repository
    checkout scm
  }

  stage("Permissions"){
    // change directory
    sh "cd AdminServer"
    // set maven wrapper permissions
    sh "cd AdminServer && chmod 711 ./mvnw"
  }

  stage("Test"){
    // run tests
    sh "./mvnw test"
  }

  stage("Build Project"){
    // build the project 
    sh "./mvnw clean install"
  }

  stage("Build Image"){
    app = docker.build("zechheneveld/admin-server")
  }

  stage("Push Image"){
    // push the image to docker hub
    sh "echo TODO"
  }

}
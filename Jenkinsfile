node {
  def app

  stage("clone repository"){
    // clone the repository
    checkout scm
  }

  stage("Permissions"){
    // change directory
    dir("AdminServer"){
    // set maven wrapper permissions
      sh "chmod 711 ./mvnw"
    }
  }

  stage("Test"){
    // run tests
    dir("AdminServer"){
      sh "./mvnw test"
    }
    
  }

  stage("Build Project"){
    dir("AdminServer"){
      // build the project 
      sh "./mvnw clean install"
    }
    
  }

  stage("Build Image"){
    dir("AdminServer"){
      app = docker.build("zechheneveld/admin-server")
    }
    
  }

  stage("Push Image"){
    dir("AdminServer"){
      // push the image to docker hub
      docker.withRegistry("https://registry.hub.docker.com", "docker-hub-credentials"){
        app.push("${env.BUILD_NUMBER}")
        app.push("latest")
      }
    } 
  }
}
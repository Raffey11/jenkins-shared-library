#!/usr/bin/env groovy

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "building the docker image..."
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh 'docker build -t raffey/java-maven-app:1.1 .'
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
            script.sh 'docker push raffey/java-maven-app:1.1'
        }
    }
}

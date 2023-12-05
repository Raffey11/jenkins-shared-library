#!/usr/bin/env groovy

def buildImage(String imageName) {
    return new Docker(this).buildDockerImage(imageName)
}
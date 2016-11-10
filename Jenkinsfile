node {
    stage('SCM') {
        git 'https://github.com/AndyYSWoo/DevOpsProject.git'
    }
    stage('QA') {
        sh '/usr/local/src/sonar-scanner-2.8/bin/sonar-scanner'
    }
    stage('build') {
        def mvnHome = tool 'M3'
        sh "${mvnHome}/bin/mvn -B clean package"
    }
    stage('deploy') {
        sh "docker stop devops || true"
        sh "docker rm devops || true"
        sh "docker run --name devops -p 11111:8080 -d tomcat"
        sh "docker cp target/DevOpsProject.war devops :/usr/local/tomcat/webapps"
    }
    stage('results') {
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }
}

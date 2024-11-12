pipeline{
    agent any

    environment{
        DOCKERHUB_CREDENTIALS = credentials("docker-hub")
    }

    stages{
        stage("Print"){
            steps{
                echo "${env.BUILD_ID}"
            }
        }

        stage("Permission"){
            steps{
                sh "chmod +x ./gradlew"
            }
        }

        stage("Compile"){
            steps{
                sh "./gradlew compileJava"
            }
        }

        stage("Unit Test"){
            steps{
                sh "./gradlew test"
            }
        }

        stage("Code Coverage"){
            steps{
                sh "./gradlew jacocoTestCoverageVerification"
                sh "./gradlew jacocoTestReport"
                    publishHTML(target: [
                        reportDir: 'build/reports/jacoco/test/html',
                        reportFiles: 'index.html',
                        reportName: 'Jacoco Report'
                ])
            }
        }

         stage("Static Code Analysis"){
            steps{
                sh "./gradlew checkstyleMain"
                    publishHTML(target: [
                                reportDir: 'build/reports/checkstyle/',
                                reportFiles: 'main.html',
                                reportName: 'Checkstyle Report'
                    ])
            }
         }

         stage("Gradle Build"){
            steps{
                sh "./gradlew clean build"
            }
         }

         stage("docker image build"){
            steps{
                sh "docker build -t ggnagpae1/jenkins1112:latest ."
            }
         }

         stage('docker hub login'){
            steps{
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
         }

         stage('docker hub push'){
            steps{
                sh "docker push ggnagpae1/jenkins1112:latest"
            }
         }

         stage('deploy'){
            steps{
                sh "docker run -d --rm -p 8765:8080 --name jenkins1112 ggnagpae1/jenkins1112"
            }
        }

         stage('acceptance test'){
            steps{
                sleep 60
                sh 'chmod +x acceptance_test.sh && ./acceptance_test.sh'
            }
         }

        stage('clean up'){
            steps{
                sh 'docker stop jenkins1112'
            }
        }
    }

    post{
        always{
            echo "finalize"
        }
    }
}
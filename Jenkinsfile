pipeline {
    agent any

    environment {
        registry = "orhan54/webappspringboot2026"
        registryCredential = 'dockerhub-creds'
    }

    tools {
        maven 'maven'
        jdk 'JDK21'
    }

    stages {
        stage('Clean workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Git Checkout') {
            steps {
                git branch: 'main',
                    credentialsId: 'jenkins_github_path',
                    url: 'https://github.com/orhan54/webAppSpringboot.git'
            }
        }

        stage('Build Maven') {
            steps {
                // Compile le projet et génère le JAR
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Generate Allure Report') {
            steps {
                bat 'mvn allure:report'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build l'image depuis le Dockerfile et le contexte actuel
                    def dockerImage = docker.build("${registry}:latest", ".")
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', registryCredential) {
                        docker.image("${registry}:latest").push()
                    }
                }
            }
        }

        stage('Deploy docker-compose') {
            steps {
                // Stop les anciens conteneurs pour libérer le port 9001
                bat 'docker-compose down'

                // Build et relance tous les services avec docker-compose
                bat 'docker-compose up -d --build --force-recreate --remove-orphans'
            }
        }

        stage('Verify Deployment') {
            steps {
                bat 'docker-compose ps'
            }
        }
    }

    post {
        always {
            allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']],
                commandline: 'allure'
            ])
        }
    }
}
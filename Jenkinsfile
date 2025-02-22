pipeline {
    agent any

    tools {
        maven 'maven3'
    }
    
    environment {
        DOCKER_IMAGE = "fryker/todo-api"
        DOCKER_TAG = "v1.2"
        DOCKER_REGISTRY_CREDENTIALS = "docker-creds" // Jenkins credentials ID
        EC2_USER = "ubuntu"
        EC2_HOST = "35.175.224.85"
        SSH_CREDENTIALS = "ssh-creds" // Jenkins credentials ID
    }

    stages {
        stage('Cleanup Workspace') {
            steps {
                cleanWs() // Cleans the workspace before checkout
            }
        }
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/mouzong/todo-api-jan-2025.git'
            }
        }

        stage('Build Application') {
            steps {
                sh 'whoami'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }

        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: DOCKER_REGISTRY_CREDENTIALS, url: ""]) {
                    sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
            }
        }

        stage('Deploy on EC2') {
            steps {
                script {
                    sshagent(['ssh-creds']) {
                        sh """
                        ssh -o StrictHostKeyChecking=no ${EC2_USER}@${EC2_HOST} << 'EOF'
                        docker stop todo-api || true
                        docker rm todo-api || true
                        docker pull ${DOCKER_IMAGE}:${DOCKER_TAG}
                        docker run -d --name todo-api -p 9394:9394 ${DOCKER_IMAGE}:${DOCKER_TAG}
                        EOF
                        """
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed!'
        }
    }

 }
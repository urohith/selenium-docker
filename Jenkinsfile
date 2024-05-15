pipeline{
    agent any

    stages
    {
        stage('Build Jar')
        {
            steps
            {
                // Run command
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image')
                {
                    steps
                    {
                        // Run command
                        bat "docker build -t=rohithdocker/selenium_curljq ."
                    }
                }
        stage('push Image')
                        {
                        environment
                        {
                        DOCKER_HUB = credentials('dockerhub-cred')
                        }
                            steps
                            {
                                bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
                                // Run command
                                bat "docker push rohithdocker/selenium_curljq"
                            }
                        }
                      }
                      post
                      {
                      always
                      {
                      bat "docker logout"
                      }
                      }

}
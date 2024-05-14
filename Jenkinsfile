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
                            steps
                            {
                                // Run command
                                bat "docker push rohithdocker/selenium_curljq"
                            }
                        }
    }

}
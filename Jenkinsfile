node {
    try {
        stage('Checkout') {
              git branch: 'Spring_Security_Class_Config',
                changelog: false,
                poll: false,
                url: "https://github.com/nurzhankydyralieva/News_Portal_SpringMVC_XML_CLASS_Config.git"
        }
        stage ('Package Stage') {
            echo "Packing the project..."
            bat 'mvn package'
        }
        stage('Test & Jacoco Static Analysis') {
              echo "Running tests junit and jacoco..."
            junit 'target/surefire-reports/**/*.xml'
            jacoco()
        }
        stage('Sonar Scanner Coverage') {
            echo "Running sonar scanner coveriage..."
             bat "mvn sonar:sonar -Dsonar.login=squ_d7f23e2388dccc43fd4dda0fba56c0a5bba77a6f -Dsonar.host.url=http://localhost:9000"
        }
        stage ('Deploy on Tomcat Server') {
             echo "Deploy on Tomcat Server"
            deploy adapters: [tomcat8(credentialsId: 'tomcat-deploy', path: '', url: 'http://localhost:8089')], contextPath: '/api', war: '**/*.war'
        }
    }
    catch (e) {
        def to = "nurrun91@gmail.com"
        currentBuild.result = 'FAILURE'
        def subject = "Jenkins - Build FAILURE"
        def content = '${JELLY_SCRIPT,template="html"}'
        emailext(body: content, mimeType: 'text/html',
                replyTo: '$DEFAULT_REPLYTO', subject: subject,
                to: to)
    }
}

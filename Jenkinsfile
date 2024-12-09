pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                catchError {
                    browserstack(credentialsId: 'e95a8d84-1a4d-4488-b561-27d79ebaa786') {
                        sh 'export BROWSERSTACK_BUILD_NAME=$( date "+%F_%H:%M:%S" ); mvn install -Dconfig=stage_desktop_chrome -Dpropone=one -DbuildUrl=http://10.200.20.7:8081/job/1%Test%20automation/105/ -Dproptwo=two -Dpropthree=three -Dgroups=smoke -Dbrowser=Chrome -DqTest=true -Dbrowserstack.config=browserstack.yml'
                    }
                }
            }
        }
    }
}

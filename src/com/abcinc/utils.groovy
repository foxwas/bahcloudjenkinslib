package com.abcinc;

def checkout() {
   node {
	stage 'Checkout'
	git url: 'C:\\Software\\repos\\SimpleGreeting.git'
   }
}

def mvn_install() {
  node {
	stage 'Install'
	bat 'mvn install'
  }
}

def mvn_clean() {
  node {
	stage 'Clean'
	bat 'mvn clean'
  }
}

def mvn_verify() {
  node {
	stage 'Verify'
	bat 'mvn verify'
  }
}

def archive_reports() {
  node {
	stage 'Archive Reports'
	step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
  }
}

def user_acceptance(wsdir)  {
  node {
	stage 'User Acceptance Test'
			
def response= input message: 'Is this build good to go?',
		 parameters: [choice(choices: 'Yes\nNo', 
		 description: '', name: 'Pass')]

	if(response=="Yes") {
	    stage 'Deploy'

	    bat "xcopy \"$WORKSPACE\\target\\SimpleGreeting*.jar\" C:\\workspace\\dev\\ /y"
	}	
  }
}

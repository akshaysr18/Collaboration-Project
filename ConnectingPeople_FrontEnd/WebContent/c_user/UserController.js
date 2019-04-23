myApp.controller('UserController',function($scope,$http,$location,$rootScope,$cookieStore)
	{
	
	$scope.User={'username':'','password':'','customerName':'','emailId':'','role':'','status':'','isOnline':''};
	
	$cookieStore.put($rootScope.currentUser);
	$scope.register=function()
	{
		console.log('I am in Register Function');
		
		$scope.User.role='Student';
		$scope.User.status='A';
		$scope.User.isOnline='On';
		
		console.log('User details are :');
		console.log($scope.User);
		
		$http.post('http://localhost:8083/ConnectingPeople_MiddleWare/registeruser',$scope.User)
		.then(function(respone){
		
			console.log('Registered');
			 if(response.status==200)
		    	{
		    	$location.path('/userhome');
		    	}
			
		});
		
	}
	
	$scope.checklogin=function()
	{
		console.log('I am in Login Function');
		
		$http.post('http://localhost:8083/ConnectingPeople_MiddleWare/checklogin',$scope.User)
		.then(function(response){
			console.log('Login Checked')
			$scope.User=response.data;
			$rootScope.currentUser=response.data;
			console.log($rootScope.currentUser);
			$cookieStore.put('UserDetail',$rootScope.currentUser);
			$location.path('/userhome')
		});
				
	}
	
	$scope.logout=function()
	{
		console.log('I am in Logout Function');
		delete $rootScope.currentUser;
		$cookieStore.remove('UserDetail');
		$location.path('/logout');
	}
	
	});

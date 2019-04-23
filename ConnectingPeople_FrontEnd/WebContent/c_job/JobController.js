myApp.controller('JobController',function($scope,$http,$location,$rootScope,$cookieStore)
 {
	 
	$scope.job={'Desgination':'','JobDesc':'','Qualification':'','status':''};
	$scope.loadjobs;
	$scope.jobdata;
	$rootScope.jobdetail
	
	$scope.addjob=function()
	   {
		   console.log('Adding Job');
		   		   
		   $scope.job.status='Approve';
		   $http.post('http://localhost:8083/ConnectingPeople_MiddleWare/addjob',$scope.job)
		   .then(function(response)
		    {
			    console.log('Job Added');
			    if(response.status==200)
		    	{
		    	$location.path('/userhome');
		    	}
			    
			});
	   }
	
	$scope.deletejob=function(jobId)
	   {
		   console.log('Deleting job');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/deletejob/'+jobId)
		   .then(function(response){
			   if(response.status==200)
		    	{
		    	$location.path('/userhome');
		    	}
		   });
	   }
	
	 function loadjobs()
	   {
		   console.log('Loading All Jobs');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/listjobs')
		   .then(function(response)
			{
			   console.log('Loading Job');
			   $scope.jobdata=response.data;
			   console.log($scope.jobdata);
			});	
	   }
	 
	 $scope.editjob=function(jobId)
	   {
		   console.log('Editing job');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/getjob/'+jobId)
		   .then(function(response){
			  $rootScope.jobdetail=response.data;
			  console.log($rootScope.jobdetail);
			  $location.path('/updatejob');
		   });
		   
	   }
	   
	   $scope.updatejob=function()
	   {
		   console.log('Updating job');
		   $scope.job=$rootScope.jobdetail;
		   $http.post('http://localhost:8083/ConnectingPeople_MiddleWare/updatejob',$scope.job)
		   .then(function(response){
			  console.log('job Is Updated');
			  $location.path('/managejobs');
		   });
	   }
	    
         loadjobs();
	
  });
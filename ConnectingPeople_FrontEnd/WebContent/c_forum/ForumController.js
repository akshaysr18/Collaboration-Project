myApp.controller('ForumController',function($scope,$http,$location,$rootScope,$cookieStore)
	{
	
	   $scope.forum={'forumName':'','forumContent':'','userName':'','status':''};
	   $scope.forumdata;
	   $scope.loadforum;
	   $rootScope.foruminfo;
	   
	   $scope.addforum=function()
	   {
		   console.log('Adding Forum Function');
		   
		   $scope.forum.userName=$rootScope.currentUser.username;
		   $scope.forum.status='A';
		   $http.post('http://localhost:8083/ConnectingPeople_MiddleWare/addForum',$scope.forum)
		   .then(function(response)
		    {
			    console.log('Forum Added');
			    console.log(response.data);
			    if(response.status==200)
		    	{
		    	$location.path('/userhome');
		    	}
			});
	   }
	   
	   function loadforum()
	   {
		   console.log('Loading All Forums');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/getForum')
		   .then(function(response)
			{
			   console.log('Loading Forum');
			   $scope.forumdata=response.data;
			   console.log($scope.forumdata);
			});	
	   }
	  
	   
	   
	   $scope.deleteforum=function(forumId)
	   {
		   console.log('Deleting Forum');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/deleteforum/'+forumId)
		   .then(function(response){
			   if(response.status==200)
		    	{
		    	$location.path('/userhome');
		    	}
			   
		   });
	   }
	   
	   $scope.showforum=function(forumId)
	   {
		   console.log('Showing Forum Details');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/getforum/'+forumId)
		   .then(function(response){
			  $rootScope.foruminfo=response.data;
			  console.log($rootScope.foruminfo);
			  $location.path('/showforum');
		   });
		   
	   }
	   
	   $scope.editforum=function(forumId)
	   {
		   console.log('Editing Forum');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/getforum/'+forumId)
		   .then(function(response){
			   $rootScope.foruminfo=response.data;
			   console.log($rootScope.foruminfo);
			   $location.path('/updateforumDetail');
		   });
	   }
	   $scope.updateForum=function()
	   {
		   console.log('Updating Forum');
		   $scope.forum=$rootScope.foruminfo;
		   $http.post('http://localhost:8083/ConnectingPeople_MiddleWare/updateforum',$scope.forum)
		   .then(function(response){
			  console.log('Forum Is Updated');
			  if(response.status==200)
		    	{
		    	$location.path('/showforum');
		    	}
			 
		   });
		   
	   }
	   
	   loadforum();
	   	
    });

myApp.controller('BlogController',function($scope,$http,$location,$rootScope,$cookieStore)
	{
	
	   $scope.blog={'blogName':'','blogContent':'','username':'','status':'','likes':0,'dislikes':0};
	   $scope.blogdata;
	   $scope.loadblog;
	   $rootScope.bloginfo;
	   
	   $scope.addblog=function()
	   {
		   console.log('Adding Blog Function');
		   
		   $scope.blog.username=$rootScope.currentUser.username;
		   $scope.blog.status='NA';
		   $http.post('http://localhost:8083/ConnectingPeople_MiddleWare/addblog',$scope.blog)
		   .then(function(response)
		    {
			   
			    console.log('Blog Added');
			    if(response.status==200)
			    	{
			    	$location.path('/showblog');
			    	}
				  

			});
		  
	   }
	   
	   function loadblog()
	   {
		   console.log('Loading All Blogs');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/getBlogDetails')
		   .then(function(response)
			{
			   console.log('Loading Blog');
			   $scope.blogdata=response.data;
			   console.log($scope.blogdata);
			});	
	   }
	   
	   $scope.incrementlikes=function(blogId)
	   {
		   console.log('Increment Likes');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/incrementlikes/'+blogId)
		   .then(function(response){
			   
		   });
		   if(response.status==200)
	    	{
	    	$location.path('/showblog');
	    	}
		  
	   }
	   
	   $scope.incrementdislikes=function(blogId)
	   {
		   console.log('Increment DisLikes');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/incrementdislikes/'+blogId)
		   .then(function(response){
			   if(response.status==200)
		    	{
		    	$location.path('/showblog');
		    	}
			  
			   
		   });
	   }
	   
	   $scope.approveblog=function(blogId)
	   {
		   console.log('Approving Blog');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/approveblog/'+blogId)
		   .then(function(response){
			   if(response.status==200)
		    	{
		    	$location.path('/userhome');
		    	}
			  
			   
		   });
	   }
	   
	   $scope.rejectblog=function(blogId)
	   {
		   console.log('Rejecting Blog');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/rejectblog/'+blogId)
		   .then(function(response){
			   if(response.status==200)
		    	{
		    	$location.path('/userhome');
		    	}
			  
		   });
	   }
	   
	   $scope.deleteblog=function(blogId)
	   {
		   console.log('Deleting Blog');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/deleteblog/'+blogId)
		   .then(function(response){
			   if(response.status==200)
		    	{
		    	$location.path('/addblog');
		    	}
			  
		   });
	   }
	   
	   $scope.showblog=function(blogId)
	   {
		   console.log('Showing Blog Details');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/getblog/'+blogId)
		   .then(function(response){
			  $rootScope.bloginfo=response.data;
			  console.log($rootScope.bloginfo);
			  $location.path('/blogdetail');
		   });
		   
	   }
	   
	   $scope.editblog=function(blogId)
	   {
		   console.log('Editing Blog');
		   $http.get('http://localhost:8083/ConnectingPeople_MiddleWare/getblog/'+blogId)
		   .then(function(response){
			   $rootScope.bloginfo=response.data;
			   console.log($rootScope.bloginfo);
			   $location.path('/updateBlogDetail');
		   });
	   }
	   $scope.updateBlog=function()
	   {
		   console.log('Updating Blog');
		   $scope.blog=$rootScope.bloginfo;
		   $http.post('http://localhost:8083/ConnectingPeople_MiddleWare/updateblog',$scope.blog)
		   .then(function(response){
			  console.log('Blog Is Updated');
			  if(response.status==200)
		    	{
		    	$location.path('/showblog');
		    	}
			  
			  $location.path('/blogdetail');
		   });
		   
	   }
	   
	   loadblog();
	   	
    });

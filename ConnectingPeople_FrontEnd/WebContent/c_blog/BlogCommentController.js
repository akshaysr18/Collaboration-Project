myApp.controller('BlogCommentController',function($scope,$http,$location,$rootScope,$cookieStore)
{
	$scope.blogComment={'commentId':'0','blogId':'0','commentText':'','commentDate':'','username':''};
	
	$scope.listBlogComments;
	$rootScope.currentUser;
	$rootScope.bloginfo;
	
	$scope.addBlogComment=function()
	{
		console.log('Adding Blog Comment')
		$scope.blogComment.blogId=$rootScope.bloginfo.blogId;
		$scope.blogComment.username=$rootScope.currentUser.username;
		
		$http.post('http://localhost:8083/ConnectingPeople_MiddleWare/addBlogComment',$scope.blogComment)
		.then(function(response){
			console.log('Blog Comment Added')
			 if(response.status==200)
		    	{
		    	$location.path('/userhome');
		    	}
			
		});
	}
	function listBlogComments()
	{
		console.log('Loading Blog Comment');
		$http.get('http://localhost:8083/ConnectingPeople_MiddleWare/listBlogComments/'+$scope.bloginfo.blogId)
		.then(function(response){
			
			$scope.listBlogComments=response.data;
		});
	}
	
	$scope.deleteblogComment=function(commentId)
	{
		console.log('Deleting Comment')
		$http.get('http://localhost:8083/ConnectingPeople_MiddleWare/deleteblogComment/'+commentId)
		.then(function(response){
			if(response.status==200)
	    	{
	    	$location.path('/userhome');
	    	}
			
		});
		
	}
	listBlogComments();

});

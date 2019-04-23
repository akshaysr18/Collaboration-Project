var myApp=angular.module("myApp",["ngRoute","ngCookies"]);
myApp.config(function($routeProvider)
		{
			
			$routeProvider.when("/login",{templateUrl:"c_user/login.html"})
			.when("/register",{templateUrl:"c_user/register.html"})
			
			.when("/Home",{templateUrl:"c_home/Home.html"})
			.when("/userhome",{templateUrl:"c_home/UserHome.html"})
			.when("/myCarousel",{templateUrl:"c_home/UserHome.html"})
			.when("/aboutUs",{templateUrl:"c_home/aboutUs.html"})

						
			.when("/aboutus",{templateUrl:"c_user/AboutUs.html"})
			
			.when("/addblog",{templateUrl:"c_blog/blog.html"})
			.when("/showblog",{templateUrl:"c_blog/showblog.html"})
			.when("/manageblog",{templateUrl:"c_blog/manageblog.html"})
			.when("/blogdetail",{templateUrl:"c_blog/BlogDetail.html"})
		    .when("/updateBlogDetail",{templateUrl:"c_blog/updateBlog.html"})
		    
		    
		    .when("/addforum",{templateUrl:"c_forum/showforum.html"})
			.when("/showforum",{templateUrl:"c_forum/showforum.html"})
			.when("/manageforum",{templateUrl:"c_forum/manageforum.html"})
		    .when("/updateforumDetail",{templateUrl:"c_forum/updateForum.html"})
		    
		    
		    .when("/FriendList",{templateUrl:"c_friend/FriendList.html"})
		    .when("/chat",{templateUrl:"c_chat/Chat.html"})
		    
		    .when("/showjobs",{templateUrl:"c_job/Job.html"})
			.when("/managejobs",{templateUrl:"c_job/ManageJob.html"})
			.when("/updatejob",{templateUrl:"c_job/UpdateJob.html"})
			
		    .when("/ProfilePicture",{templateUrl:"c_user/ProfilePicture.html"});

			
		});

myApp.run(function($rootScope,$cookieStore){
	
	console.log('I am in Run Function');
	console.log($rootScope.currentUser);
	
	if($rootScope.currentUser==undefined)
		
	{
		
		console.log($cookieStore.get('userDetails'));
		$rootScope.currentUser=$cookieStore.get('UserDetail')
		}
	
	
		

});
 myApp.controller("FriendController",function($scope,$http,$location,$rootScope)

	{
	 $scope.friend={'friendId':0,'username':'','friendname':'','status':''};
		$scope.User={'username':'','password':'','customerName':'','emailId':'','role':'','status':'','isOnline':''};
		
		$scope.showFriendList;
		$scope.ShowPendingFriendList;
		$scope.showSuggestedFriend;
		$rootScope.currentUser;
		$scope.friend;
		
	
		function showFriendList()
		{
			console.log('I am in showFriendList');
			console.log($rootScope.currentUser.username);
			$http.get('http://localhost:8083/ConnectingPeople_MiddleWare/showFriendList/'+$rootScope.currentUser.username)
			.then(function(response){
				$scope.showFriendList=response.data;
				console.log($scope.showFriendList);
				
			});
			
		}
		
		function ShowPendingFriendList()
		{
			console.log('I am ShowPendingFriendList');
			console.log($rootScope.currentUser.username);
			$http.get('http://localhost:8083/ConnectingPeople_MiddleWare/showPendingFriendList/'+$rootScope.currentUser.username)
			.then(function(response){
				$scope.ShowPendingFriendList=response.data;
				console.log($scope.ShowPendingFriendList);
				
			});
		}
		function showSuggestedFriend()
		{
			console.log('I am showSuggestedFriend');
			console.log($rootScope.currentUser.username);

			$http.get('http://localhost:8083/ConnectingPeople_MiddleWare/showSuggestedFriend/'+$rootScope.currentUser.username)
			.then(function(response){
				$scope.showSuggestedFriend=response.data;
				console.log($scope.showSuggestedFriend);
				
			});
		}
		$scope.unfriend=function(friendId)
		{
			console.log('unfriend the Person');
			$http.get('http://localhost:8083/ConnectingPeople_MiddleWare/deleteFriendRequest/'+friendId)
			.then(function(response){
				$scope.log('Deleting the Friend');
				
			});
		}
		$scope.acceptFriend=function(friendId)
		{
			console.log('Accepting  the Request');
			$http.get('http://localhost:8083/ConnectingPeople_MiddleWare/acceptFriendRequest/'+friendId)
			.then(function(response){
				$scope.log('Accepting the Friend');
				
			});
		}
		$scope.sendFriendRequest=function(frndname)
		{

			$scope.friend.username=$rootScope.currentUser.username;
			$scope.friend.friendname=frndname;
			$http.post('http://localhost:8083/ConnectingPeople_MiddleWare/sendFriendRequest/',$scope.friend)
			.then(function(response){
				$scope.log('Sending  Friend Request');
				
			});
		}

		showFriendList();
		ShowPendingFriendList();
		showSuggestedFriend();
	});
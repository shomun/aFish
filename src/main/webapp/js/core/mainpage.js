var MainPage = Class.create( {
	
	initialize : function(o) {
		this._componentId = o['componentId']
		this._init(o);
	},
	
	_init : function(o) {
		//init header
		clientSideInclude('header', 'header.html');	
		//init content
		clientSideInclude('content', 'content.html');	
		//init footer
		clientSideInclude('footer', 'footer.html');	
//		var init = {};
//		this._gameController = ComponentManager.loadComponent({
//	        componentId: 'game_controller',
//	        jsClassName: 'GameController',
//	        initData: init
//		});	
//		
//		var scoreBoardModel = ComponentManager.getComponentById('scoreboard_model');
//		
//		init = {};
//		
//		init.model = scoreBoardModel;
//		
//		this._scoreBoardView =  ComponentManager.loadComponent({
//	        componentId: 'scoreboard_view',
//	        jsClassName: 'ScoreBoardView',
//	        initData: init
//		});	 
//		DataManager.clearGameHistory();
	},
	
	newUser : function(){
//		alert("hello");
		var newUserPnl =  $("newuser");
		newUserPnl.style.display = "block";
	}
	
});
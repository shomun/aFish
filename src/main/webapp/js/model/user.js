
var User = Class.create({

	initialize : function(){
		this._id ="";
		this._name = "";
		this._loginId = "";
		this._password = "";
		this._dob = "";
		this._sex = "";
		this._email = "";
		
	},
	
	_init : function(o){
		this._id = o.id;
		this._name = o.name;
		this._loginId = o.loginId;
		this._password = o.password;
		this._dob = o.dob;
		this._sex = o.sex;
		this._email = o.email;
	},
	
	register:function(){
		var urlStr ="/user/register?id="+this._id+"&name="+this._name;
	}


});

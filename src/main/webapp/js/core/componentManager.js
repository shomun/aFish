
//prevent re-definition of EventHandler
/**
 * @namespace management of Component functions.
 */
var ComponentManager = {
	/**
	 * Loaded components.
	 * @private
	 * @fieldOf ComponentManager
	 */
	components : [],
	/**
	 * Register and initialize a component.
	 * component-info for loading.
	 <pre>
	 {
	  	componentId : id, // require  
	  	jsClassName : klass, 
	   componentDefId : defId,
	   initData : { write : your , original : data} // optional
	 };
	 </pre>
	 * @methodOf ComponentManager
	 * @param objComponent Object
	 * @returns {Object} loaded component.
	 */
	loadComponent : function(objComponent) {
		var compo = this.components[objComponent.componentId];
		if(compo) {
			if(compo.destroy)compo.destroy();
			delete this.components[objComponent.componentId];
			delete compo;
		}
		if (objComponent.jsClassName) {
			var Constr = null;
			if (typeof objComponent.jsClassName == "string") {
				Constr = window[objComponent.jsClassName];
			} else {
				Constr = objComponent.jsClassName;
			}
//			compo = new Constr();

			if (!objComponent.initData) {
				objComponent.initData = {};
			}
			objComponent.initData.componentId = objComponent.componentId;
//			objComponent.initData.componentDefId = objComponent.componentDefId;
			var data = objComponent.initData;
//			compo.init(data);
			compo = new Constr(data);

			this.components[objComponent.componentId] = compo;
		}
		return compo;
	},

	/**
	 * Access to component with ID.
	 * @methodOf ComponentManager
	 * @param componentId String
	 *   key of components.
	 * @returns Object
	 */
	getComponentById : function(componentId) {
		return this.components[componentId];
	},

	removeComponent : function(id) {
		if(this.components[id]){
			delete this.components[id];
		}
	},
	/**destroy all component under this elm */
	destroyComponent : function(elm) {
		var deleteCompIds = [];
		for(var id in this.components) {
			if(this.components[id].getHtmlElement){
				var componentElm = this.components[id].getHtmlElement();
				if(componentElm && (componentElm==elm || Element.ancestors(componentElm).indexOf(elm)>=0)) {
					if(this.components[id].destroy) this.components[id].destroy();
					deleteCompIds.push(id);
				}
			}
		}
		for(var i=0; i<deleteCompIds.length; i++){
			this.removeComponent(deleteCompIds[i]);
		}
	}
};

/**
 * Shortcut of ComponentManager.getComponentById
 * @function 
 * @param componentId
 * @returns {Object} managed component.
 */
function $C(componentId){
	return ComponentManager.getComponentById(componentId);
}



function componentExecFunction(componentId, functionName, args){
	try{
		var comp = ComponentManager.getComponentById(componentId);
		var execFunction = eval( "comp." + functionName);
		execFunction.apply(comp, args);
	}catch (e) {
		alert(e);
	}
	
}

function componentExecFunctionWithCall(componentId, functionName, args){
	try{
		var comp = ComponentManager.getComponentById(componentId);
		var execFunction = eval( "comp." + functionName);
		execFunction.call(comp, args);
	}catch (e) {
		alert(e + "functionName:" + functionName);
	}
	
}
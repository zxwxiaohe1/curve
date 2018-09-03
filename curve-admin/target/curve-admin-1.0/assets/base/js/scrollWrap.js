
var scrollBar = {};	

(function(win,doc,$){

	function CusScrollBar(options){
		this._init(options);
	};

	$.extend(CusScrollBar.prototype, {

		_init:function(options){	
			var self = this;		
			self.options = {
				scrollDir : "y",	
				contSelector : "",	
				barSelector	: "",	
				sliderSelector : "",
				tabItemSelector: "",
				tabActiveClass: "",	
				anchorSelector: "",	
				wheelStep : 50		
			}
			
			$.extend(true, self.options, options||{});
			self._initDomEvent();	// 调用

			return self;
		},
		_initDomEvent : function(){
			
			var opts 	  = this.options;
			this.$cont 	  = $(opts.contSelector);
			this.$slider  = $(opts.sliderSelector);		
			this.$bar 	  = opts.barSelector ? $(opts.barSelector) : this.$slider.parent();	
			this.$tabItem = $(opts.tabItemSelector);
			this.$anchor  = $(opts.anchorSelector);
			this.$doc 	  = $(doc);
			this._initSliderDragEvent()._bindMousewheel()._bindContScroll()._initTabEvent();
		},
		getMaxScrollPosition: function(){
			var self = this;
			return Math.max(self.$cont.height(), self.$cont[0].scrollHeight) - self.$cont.height();
		},
		getMaxSliderPosition: function(){
			var self = this;
			return self.$bar.height() - self.$slider.height();
		},
		scrollTo : function(positionVal){
			var self = this;
			var posArr = self.getAllAnchorPosition();
			function getIndex(positionVal){
				for(var i = posArr.length - 1; i >= 0; i--){
					if(positionVal >= posArr[i]){
						return i;
					}
				}
			}
			//每次滚动的时候判断一下现在的位置属于哪个anchor, 然后切换到对应的tab
			if(posArr.length == self.$tabItem.length){
				self.changeTabSelect(getIndex(positionVal));
			}
			self.$cont.scrollTop(positionVal)
		},

		
		/*
		 * 初始化滑块拖动功能
		 */
		_initSliderDragEvent: function(){
			var self = this;
			var slider = self.$slider;
			var sliderEl = slider[0];
			if(sliderEl){
				var doc = self.$doc,
						  dragStartPagePosition,
						  dragStartScrollPosition,
						  dragContBarRate;

				dragContBarRate = self.getMaxScrollPosition() / self.getMaxSliderPosition();
				function mousemoveHandle(e){
					e.preventDefault();
					console.log("mousemove");
					if(dragStartPagePosition == null){ return; }
					self.scrollTo(dragStartScrollPosition + (e.pageY - dragStartPagePosition) * dragContBarRate);
				}

				slider.on("mousedown", function(e){
					e.preventDefault();
					console.log("mousedown");
					dragStartPagePosition = e.pageY;
					dragStartScrollPosition = self.$cont[0].scrollTop;

					console.log("mousedown");
					doc.on("mousemove.scroll", function(e){
						mousemoveHandle(e);
					}).on("mouseup.scroll", function(e){
						console.log("mouseup");
						doc.off('.scroll');
					});
				});
			}
			return self;
		},

		//绑定滑块移动事件
		_bindContScroll: function(){
			var self = this;
			self.$cont.on("scroll", function(){
				var sliderEl = self.$slider && self.$slider[0]
				if(sliderEl){
					sliderEl.style.top = self.getSliderPosition() + "px";
				}
			});
			return self;
		},

		//计算滑块当前位置
		getSliderPosition : function(){
			var self = this;
			return Math.min(self.getMaxSliderPosition(), self.getMaxSliderPosition() * self.$cont[0].scrollTop/self.getMaxScrollPosition());
		},

		//绑定滚轮事件
		_bindMousewheel: function(){
			var self = this;
			self.$cont.on("mousewheel DOMMouseScroll", function(e){
				e.preventDefault();
				var oEv = e.originalEvent;	// 指向原生事件
				var wheelRange = oEv.wheelDelta ? -oEv.wheelDelta / 120 : (oEv.detail || 0) / 3;
				self.scrollTo(self.$cont[0].scrollTop + wheelRange * self.options.wheelStep); 
			});

			return self;
		},

		//注册Tab切换事件
		_initTabEvent: function(){
			var self = this;
			self.$tabItem.on("click", function(e){
				e.preventDefault();
				//获取点击的tabItem的index
				var index = $(this).index();
				//这个标签变为active
				self.changeTabSelect(index);
				//对用的文章滚动到内容页面上
				self.scrollTo(self.$cont[0].scrollTop + self.getAnchorPosition(index));
			});
			return self;
		},

		//切换tab选择状态
		changeTabSelect: function(index){
			var self = this;
			var active = self.options.tabActiveClass;
			return self.$tabItem.eq(index).addClass(active).siblings().removeClass(active);
		},
		
		//获取anchor位置
		getAnchorPosition : function(index){
			return this.$anchor.eq(index).position().top;
		},

		//获取所有anchor位置数组
		getAllAnchorPosition: function(){
			var self = this;
			var allPositionArr = [];
			for(var i = 0; i < this.$anchor.length; i++){
				//锚点位置 ＝ 页面超出部分 + 当前锚点高度
				allPositionArr.push(self.$cont[0].scrollTop + self.getAnchorPosition(i));
			}
			return allPositionArr;
		}
	});
	scrollBar.CusScrollBar = CusScrollBar;	
})(window, document, jQuery);
var scroll = new scrollBar.CusScrollBar({
		contSelector : ".scroll-cont",
		barSelector	: ".scroll-bar",
		sliderSelector : ".scroll-slider",
		tabItemSelector: ".tab-item",
		tabActiveClass: "tab-active",
		anchorSelector: ".anchor"
});
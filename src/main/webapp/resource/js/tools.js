function ajax_call(the_url,the_param){
	$.ajax({
		type:'POST',
		url:the_url,
		data:the_param,
		success:function(html){alert(html);},
		error:function(html){
			alert("提交数据失败，代码:" +html.status+ "，请稍候再试");
		}
	});
}

function ajax_call_and_refresh(the_url, the_param){
	$.ajax({
		type:'POST',
		url:the_url,
		data:the_param,
		success:function(html){location.reload();},
		error:function(html){
			alert("提交数据失败，代码:" +html.status+ "，请稍候再试");
		}
	});
}

/**
 * 使用ajax提交数据
 */
function ajax_post(the_url,the_param,succ_callback){
	$.ajax({
		type	: 'POST',
		cache	: false,
		url		: the_url,
		data	: the_param,
		success	: succ_callback,
		error	: function(html){
			alert("提交数据失败，代码:" +html.status+ "，请稍候再试");
		}
	});
}

/**
 * 使用ajax获取数据
 */
function ajax_get(the_url,error_tip,succ_callback){
	$.ajax({
		type	: 'GET',
		cache	: true,
		url		: the_url,
		success	: succ_callback,
		error	: function(html){
			if(error_tip)
			alert("获取数据失败，代码:" +html.status+ "，请稍候再试");
		}
	});
}


/**
 * 使用ajax获取数据
 */
function ajax_get(the_url,succ_callback){
	$.ajax({
		type	: 'GET',
		cache	: true,
		url		: the_url,
		success	: succ_callback,
		error	: function(html){
			 
		}
	});
}


//jQuery的cookie扩展
$.cookie = function(name, value, options) {
    if (typeof value != 'undefined') { // name and value given, set cookie
        options = options || {};
        if (value === null) {
            value = '';
            options.expires = -1;
        }
        var expires = '';
        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
            var date;
            if (typeof options.expires == 'number') {
                date = new Date();
                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
            } else {
                date = options.expires;
            }
            expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
        }
        var path = options.path ? '; path=' + options.path : '';
        var domain = options.domain ? '; domain=' + options.domain : '';
        var secure = options.secure ? '; secure' : '';
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else { // only name given, get cookie
        var cookieValue = null;
        if (document.cookie && document.cookie != '') {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++) {
                var cookie = jQuery.trim(cookies[i]);
                // Does this cookie string begin with the name we want?
                if (cookie.substring(0, name.length + 1) == (name + '=')) {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
};

/**
 * Heartbeat
 */
$.jheartbeat = {
    options: {delay: 10000},
	beatfunction:  function(){},
	timeoutobj:  {id: -1},

    set: function(options, onbeatfunction) {
		if (this.timeoutobj.id > -1) {
			clearTimeout(this.timeoutobj);
		}
        if (options) {
            $.extend(this.options, options);
        }
        if (onbeatfunction) {
            this.beatfunction = onbeatfunction;
        }

		this.timeoutobj.id = setTimeout("$.jheartbeat.beat();", this.options.delay);
    },

    beat: function() {
		this.timeoutobj.id = setTimeout("$.jheartbeat.beat();", this.options.delay);
        this.beatfunction();
    }
};

function timer(func, interval){
	$.jheartbeat.set({delay: interval}, func);
}

function html_encode(str)   
{   
  var s = "";   
  if (str.length == 0) return "";   
  s = str.replace(/&/g, "&amp;");   
  s = s.replace(/</g, "&lt;");   
  s = s.replace(/>/g, "&gt;");   
  //s = s.replace(/ /g, "&nbsp;");   
  s = s.replace(/\'/g, "&#39;");   
  s = s.replace(/\"/g, "&quot;");   
  //s = s.replace(/\n/g, "<br>");   
  return s;   
}   

function html_decode(str)   
{   
  var s = "";   
  if (str.length == 0) return "";   
  s = str.replace(/&gt;/g, "&");   
  s = s.replace(/&lt;/g, "<");   
  s = s.replace(/&gt;/g, ">");   
  s = s.replace(/&nbsp;/g, " ");   
  s = s.replace(/&#39;/g, "\'");   
  s = s.replace(/&quot;/g, "\"");   
  s = s.replace(/<br>/g, "\n");   
  return s;   
}   

function HashMap()
{
     /** Map 大小 **/
     var size = 0;
     /** 对象 **/
     var entry = new Object();
     
     /** 存 **/
     this.put = function (key , value)
     {
         if(!this.containsKey(key))
         {
             size ++ ;
         }
         entry[key] = value;
     }
     
     /** 取 **/
     this.get = function (key)
     {
         if( this.containsKey(key) )
         {
             return entry[key];
         }
         else
         {
             return null;
         }
     }
     
     /** 删除 **/
     this.remove = function ( key )
     {
         if( delete entry[key] )
         {
             size --;
         }
     }
     
     /** 是否包含 Key **/
     this.containsKey = function ( key )
     {
         return (key in entry);
     }
     
     /** 是否包含 Value **/
     this.containsValue = function ( value )
     {
         for(var prop in entry)
         {
             if(entry[prop] == value)
             {
                 return true;
             }
         }
         return false;
     }
     
     /** 所有 Value **/
     this.values = function ()
     {
         var values = new Array(size);
         for(var prop in entry)
         {
             values.push(entry[prop]);
         }
         return values;
     }
     
     /** 所有 Key **/
     this.keys = function ()
     {
         var keys = new Array(size);
         for(var prop in entry)
         {
             keys.push(prop);
         }
         return keys;
     }
     
     /** Map Size **/
     this.size = function ()
     {
         return size;
     }
}

 



 
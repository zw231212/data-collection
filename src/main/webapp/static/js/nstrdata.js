(function () {
    //alert(1);
    var params = {},
        comment={
          "score":"", "contact":"",
          "content":"", "click_button":"",
          "resource":""
        };
    //Document对象数据
    if (document) {
        params.domain = document.domain || '';
        params.url = document.URL || '';
        params.title = document.title || '';
        params.referrer = document.referrer || '';
    }
    //Window对象数据
    if (window && window.screen) {
        params.sh = window.screen.height || 0;
        params.sw = window.screen.width || 0;
        params.cd = window.screen.colorDepth || 0;
    }
    //navigator对象数据
    if (navigator) {
        params.lang = navigator.language || '';
        params.ua = navigator.userAgent || '';
    }
    //解析_maq配置
    if (_maq) {
        for (var i in _maq) {
            switch (_maq[i][0]) {
                case '_setAccount':
                    params.account = _maq[i][1];
                    break;
              case '_setScore':
                comment.score = _maq[i][1];
                break;
              case '_setContact':
                comment.contact = _maq[i][1];
                break;
              case '_setContent':
                comment.content = _maq[i][1];
                break;
              case '_setClickButton':
                comment.click_button = _maq[i][1];
                break;
              case '_setResource':
                comment.resource = _maq[i][1];
                break;
              default:
                    break;
            }
        }
        console.log(comment)
        if(comment.click_button){
          document.getElementById(comment.click_button).addEventListener("click",clickHandler);
        }
    }

    function dealParams() {
      //拼接参数串
      var args = '';
      for (var i in params) {
        // alert(i);
        if (args != '') {
          args += '&';
        }
        args += i + '=' + params[i];
      }
      return args;
    }

    function clickHandler(e) {
        var score = document.getElementById(comment.score);
        var content = document.getElementById(comment.content);
        var contact = document.getElementById(comment.contact);
        params.score = score.value || '';
        params.contact = contact.value || '';
        params.content = content.value || '';
        var args = dealParams();
        var img = new Image(1, 1);
        var src = 'http://localhost:8082/data/collection/log.gif?args=' + encodeURIComponent(args);
        //alert(src);
        img.src = src;
    }
    //通过伪装image对象请求后端脚本
    // var img = new Image(1, 1);
    // var src = 'http://localhost:8082/data/collection/log.gif?args=' + encodeURIComponent(args);
    //alert(src);
    // img.src = src;
})();
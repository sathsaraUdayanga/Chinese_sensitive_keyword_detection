riot.mixin({

    _url: 'http://localhost:8080/keywords',
    api: riot.observable(),
    apiSerach: function (content) {
        let req = `${this._url}`
        // Create new request
        let xhr = new XMLHttpRequest()
        //.......................................
        xhr.open('POST', req)
        xhr.send(content);
        //.......................................

        this.sleep(500);
        xhr.open('GET', req)
        xhr.onload = () => {
            let res = (xhr.status === 200) ? JSON.parse(xhr.responseText) : null
            this.api.trigger('complete', res)
        }
        xhr.send()
    },
    sleep: function (milliseconds) {
        var start = new Date().getTime();
        for (var i = 0; i < 1e7; i++) {
          if ((new Date().getTime() - start) > milliseconds){
            break;
          }
        }
      }
});
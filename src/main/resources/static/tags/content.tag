<content>
    <form onsubmit={search}>
        <fieldset>
            <label for="commentField">Content</label>
            <textarea ref="search" placeholder="web page content here …" id="commentField" style="height:300px"></textarea>
            <input class="button-primary" type="submit">
        </fieldset>
    </form>

    <script>
        this.on('mount',function(){
            this.refs.search.focus()
        })

        this.search = function(e){
            e.preventDefault()
            let content = this.refs.search.value
            this.apiSerach(content)
        }
    </script>
</content>
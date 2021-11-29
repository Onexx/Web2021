<#-- @ftlvariable name="title" type="java.lang.String" -->
<#-- @ftlvariable name="text" type="java.lang.String" -->
<#-- @ftlvariable name="error" type="java.lang.String" -->
<#import "commons.ftlh" as c>

<@c.page>
    <div class="article form-box" style="float:left; width: 90%">
        <div class="header">Article creation</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="createArticle"/>
                <div class="field" style="">
                    <div class="name" style="width: initial; float: initial; text-align: initial">
                        <label for="title">Title</label>
                    </div>
                    <div class="value">
                        <input id="title" name="title" value="${title!}"/>
                    </div>
                </div>
                <div class="text">
                    <div class="name">
                        <label for="text">Text</label>
                    </div>
                    <textarea name="text" rows="10" id="text" style="width: 95%"></textarea>
                </div>
                <div class="error"></div>
                <div class="button-field">
                    <input type="submit" value="Post">
                </div>
            </form>
        </div>
    </div>

    <script>
        $(function () {
            $(".article form").submit(function () {
                const title = $(this).find("input[name='title']").val();
                const text = $(this).find("textarea[name='text']").val();
                const $error = $(this).find(".error");
                ajax({
                    data: {
                        action: "createArticle",
                        title: title,
                        text: text
                    }
                }, $error)
                return false;
            });
        })
    </script>
</@c.page>

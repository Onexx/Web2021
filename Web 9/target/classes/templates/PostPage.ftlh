<#import "commons.ftlh" as c>

<@c.page>
    <#if post??>
        <@c.post post=post/>
        <#if user??>
            <form method="post" action="">
                <div class="field">
                    <div class="name">
                        <label for="text">Add comment</label>
                    </div>
                    <div class="value">
                        <textarea id="text" name="text">${comment.text!}</textarea>
                    </div>
                    <@c.error "comment.text"/>
                </div>
                <div class="button-field">
                    <input type="submit" value="Add">
                </div>
            </form>
        </#if>
        <#list comments?reverse as comment>
            <div class="comment" style="border: 2px solid var(--datatable-color) ">
                <div class="login" style="margin-top: 0.5rem"> ${comment.user.login}:</div>
                <div class="text">
                    <a style="white-space: pre-wrap">${comment.text}</a>
                </div>
            </div>

        </#list>

    <#else>
        Post not found
    </#if>
</@c.page>
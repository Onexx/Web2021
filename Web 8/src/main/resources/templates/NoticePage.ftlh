<#import "commons.ftlh" as c>

<@c.page>
    <div class="notice form-box">
        <div class="header">Notice</div>
        <div class="body">
            <form method="post" action="">
                <div class="body">
                    <label>
                        <textarea name="content" rows="10" style="width: 95%">${noticeForm.content!}</textarea>
                    </label>
                </div>
                <@c.error "noticeForm.content"/>
                <div class="button-field">
                    <input type="submit" value="Post">
                </div>
            </form>
        </div>
    </div>
</@c.page>

<template>
    <div class="middle">
        <Sidebar :posts="viewPosts"/>
        <main>
            <Index v-if="page === 'Index'" :posts="posts" :users="users"/>
            <Users v-if="page === 'Users'" :users="users"/>
            <Enter v-if="page === 'Enter'"/>
            <Register v-if="page === 'Register'"/>
            <SinglePost v-if="page === 'PostPage'" :post="post" :users="users" :numberOfComments="post.comments.length"
                        :comments="post.comments"/>
            <WritePost v-if="page === 'WritePost'"/>
        </main>
    </div>
</template>

<script>
import Sidebar from "./sidebar/Sidebar";
import Index from "./main/Index";
import Enter from "./main/Enter";
import Register from "./main/Register";
import Users from "./main/users/Users";
import SinglePost from "./main/posts/SinglePost";
import WritePost from "./main/WritePost";


export default {
    name: "Middle",
    data: function () {
        return {
            post: null,
            page: "Index"
        }
    },
    components: {
        Register,
        Enter,
        Index,
        Sidebar,
        Users,
        SinglePost,
        WritePost
    },
    props: ["posts", "users"],
    computed: {
        viewPosts: function () {
            return Object.values(this.posts).sort((a, b) => b.id - a.id).slice(0, 2);
        }
    }, beforeCreate() {
        this.$root.$on("onChangePage", (page) => this.page = page);
        this.$root.$on("onShowPost", (post) => {
            this.post = post;
            this.page = "PostPage";
        });
    }
}
</script>

<style scoped>

</style>

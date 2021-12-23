<template>
    <div class="middle">
        <Sidebar :posts="viewPosts"/>
        <main>
            <Index v-if="page === 'Index'" :users="users" :posts="sortedPosts" :numberOfComments="numberOfComments"/>
            <Users v-if="page === 'Users'" :users="users"/>
            <Enter v-if="page === 'Enter'"/>
            <Register v-if="page === 'Register'"/>
            <WritePost v-if="page === 'WritePost'"/>
            <EditPost v-if="page === 'EditPost'"/>
            <SinglePost v-if="page === 'PostPage'" :post="post" :users="users" :numberOfComments="numberOfComments.has(post.id) ? numberOfComments.get(post.id) : 0" :comments="viewComments(post)"/>
        </main>
    </div>
</template>

<script>
import Sidebar from "./sidebar/Sidebar";
import Index from "./page/Index";
import Enter from "./page/Enter";
import WritePost from "./page/WritePost";
import EditPost from "./page/EditPost";
import Register from "./page/Register";
import Users from "./page/Users/Users"
import SinglePost from "@/components/page/Posts/SinglePost";

export default {
    name: "Middle",
    data: function () {
        return {
            post: null,
            page: "Index"
        }
    },
    components: {
        SinglePost,
        Users,
        Register,
        WritePost,
        Enter,
        Index,
        Sidebar,
        EditPost
    },
    props: ["posts", "users", "comments"],
    methods:{
        viewComments: function (post) {
            return Object.values(this.comments).filter((comment) => comment.postId === post.id);
        }
    },
    computed: {
        viewPosts: function () {
            return Object.values(this.posts).sort((a, b) => b.id - a.id).slice(0, 2);
        },
        sortedPosts: function () {
            return Object.values(this.posts).sort((a, b) => b.id - a.id);
        },
        numberOfComments: function () {
            const numberOfComments = new Map();
            Object.values(this.comments).forEach((comment) => {
                if (numberOfComments.has(comment.postId)) {
                    numberOfComments.set(comment.postId, numberOfComments.get(comment.postId) + 1);
                } else {
                    numberOfComments.set(comment.postId, 1);
                }
            });
            return numberOfComments;
        }
    }, beforeCreate() {
        this.$root.$on("onChangePage", (page) => this.page = page)
        this.$root.$on("onShowPost", (post) => {
            this.post=post;
            this.page = "PostPage";
        })
    }
}
</script>

<style scoped>

</style>

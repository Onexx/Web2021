<template>
    <div>
        <SinglePost v-for="post in posts" :post="post" :key="post.id" :users="users"
                    :numberOfComments="numberOfComments.has(post.id) ? numberOfComments.get(post.id) : 0"></SinglePost>
    </div>
</template>

<script>
import SinglePost from "@/components/page/Posts/SinglePost";

export default {
    name: "Posts",
    props: ["posts", "users", "numberOfComments"],
    components: {
        SinglePost
    }
}
</script>

<style scoped>

</style>

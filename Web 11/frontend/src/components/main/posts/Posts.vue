<template>
    <div>
        <SinglePost v-for="post in posts" :post="post" :key="post.id" :users="users"/>
    </div>
</template>

<script>
import SinglePost from "./SinglePost";

export default {
    name: "Posts",
    props: ["posts", "users"],
    components: {
        SinglePost
    }
}
</script>

<style scoped>

</style>

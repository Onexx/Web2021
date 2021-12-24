<template>
    <Posts :posts="posts" :users="users"/>
</template>

<script>
import Posts from "./posts/Posts";

export default {
    name: "Index",
    props: ["posts", "users"],
    components: {Posts}
}
</script>

<style scoped>

</style>

<template>
    <Posts :posts="posts" :users="users" :numberOfComments="numberOfComments"></Posts>
</template>

<script>
import Posts from "@/components/page/Posts/Posts";

export default {
    name: "Index",
    props: ["posts", "users", "numberOfComments"],
    components: {Posts}
}
</script>

<style scoped>

</style>

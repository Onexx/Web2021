<template>
    <footer>
        <p><a href="/">Codeforces</a> &copy; 2021 by Mike Mirzayanov</p>
        <p>Current registered users: {{ usersAmount }}</p>
        <p>Current number of posts: {{ postsAmount }}</p>
    </footer>
</template>

<script>
export default {
    name: "Footer",
    props: ["usersAmount", "postsAmount"]
}
</script>

<style scoped>

</style>
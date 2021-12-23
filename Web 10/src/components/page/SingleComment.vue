<template>
    <p>{{author}} : {{comment.text}}</p>
</template>

<script>
export default {
    name: "SingleComment",
    props: ["comment", "author"]
}
</script>

<style scoped>

</style>

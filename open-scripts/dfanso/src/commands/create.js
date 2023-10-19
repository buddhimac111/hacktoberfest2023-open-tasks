const { ActionRowBuilder, ModalBuilder, TextInputBuilder, TextInputStyle } = require('discord.js');
const { SlashCommandBuilder } = require('@discordjs/builders');
const {admin} = require('../config.json')


module.exports = {
    data: new SlashCommandBuilder()
        .setName('create')
        .setDescription('Create a new Embed MSG!'),
    async execute(interaction) {
    // Create the modal
    const embedModal = new ModalBuilder()
    .setCustomId('embedModal')
    .setTitle('Create a new Embed Msg!');

  // Create text input for event name
  const embedNameInput = new TextInputBuilder()
    .setCustomId('titleInput')
    .setLabel('Embed title')
    .setStyle(TextInputStyle.Short);

  // Create text input for description
  const descriptionInput = new TextInputBuilder()
  .setCustomId('descriptionInput')
  .setLabel('Embed Description')
  .setStyle(TextInputStyle.Paragraph);

  const thumbnailURLInput = new TextInputBuilder()
    .setCustomId('thumbnailURLInput')
    .setLabel('Thumbnail Photo URL')
    .setPlaceholder('Enter the thumbnail URL here')
    .setStyle(TextInputStyle.Short)
    .setRequired(false);

  const attachmentUrlInput = new TextInputBuilder()
    .setCustomId('documentURLInput')
    .setLabel('Attachment URL')
    .setPlaceholder('Enter the attachment URL here')
    .setStyle(TextInputStyle.Short)
    .setRequired(false);


  

  // Create action rows
  const firstActionRow = new ActionRowBuilder().addComponents(embedNameInput);
  const secondActionRow = new ActionRowBuilder().addComponents(descriptionInput);
  const thirdActionRow = new ActionRowBuilder().addComponents(thumbnailURLInput);
  const fifthActionRow = new ActionRowBuilder().addComponents(attachmentUrlInput);


  // Add components to the modal
  embedModal.addComponents(firstActionRow, secondActionRow,thirdActionRow,fifthActionRow);

        const roleId = admin; 
        const member = interaction.member;

        if (member.roles.cache.has(roleId)) {
            // Show the modal
            await interaction.showModal(embedModal);
        } else {
            interaction.reply({ content: "You don't have permission to use this command.", ephemeral: true });
            return;
        }
    }
};

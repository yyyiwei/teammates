// Import necessary modules if required
// import * as fs from 'fs';

// Define a class to represent a code snippet
class CodeSnippet {
    constructor(public id: number, public code: string, public score: number = 0) {}
}

// Define a class to manage feedback sessions
class FeedbackSession {
    private codeSnippets: CodeSnippet[] = [];

    // Add a new code snippet to the session
    addCodeSnippet(code: string): void {
        const newId = this.codeSnippets.length + 1;
        const newSnippet = new CodeSnippet(newId, code);
        this.codeSnippets.push(newSnippet);
        console.log(`Code snippet ${newId} added.`);
    }

    // List all code snippets in the session
    listCodeSnippets(): void {
        this.codeSnippets.forEach((snippet) => {
            console.log(`Code Snippet ${snippet.id}:`);
            console.log(snippet.code);
            console.log(`Score: ${snippet.score}`);
        });
    }

    // Score a code snippet
    scoreCodeSnippet(id: number, score: number): void {
        const snippet = this.findCodeSnippetById(id);
        if (snippet) {
            snippet.score = score;
            console.log(`Code snippet ${id} scored with ${score} points.`);
        } else {
            console.log(`Code snippet with ID ${id} not found.`);
        }
    }

    // Helper function to find a code snippet by ID
    private findCodeSnippetById(id: number): CodeSnippet | undefined {
        return this.codeSnippets.find((snippet) => snippet.id === id);
    }
}

// Create a feedback session
const feedbackSession = new FeedbackSession();

// Example usage:
feedbackSession.addCodeSnippet("function add(a, b) { return a + b; }");
feedbackSession.addCodeSnippet("const name = 'John';");
feedbackSession.listCodeSnippets();
feedbackSession.scoreCodeSnippet(1, 4);
feedbackSession.scoreCodeSnippet(3, 5);
feedbackSession.listCodeSnippets();

// Optionally, save feedback data to a file (e.g., for GitHub integration)
// const feedbackData = JSON.stringify(feedbackSession.codeSnippets);
// fs.writeFileSync('feedback.json', feedbackData);
